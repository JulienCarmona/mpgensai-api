package fr.mpgensai.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class StartupLoggingComponent implements InitializingBean {

    private static final String ENV_TARGET_KEY = "envTarget";
    private static final String PERSISTENCE_TARGET_KEY = "persistenceTarget";
    private static final String ACTIVE_SPRING_PROFILE_KEY = "spring.profiles.active";
    private static final String PERSISTENCE_HOST_KEY = "spring.datasource.url";
    @Autowired
    private Environment env;

    public StartupLoggingComponent() {
        super();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("============================================================================");
        try {
            logEnvTarget(env);
            logPersistenceTarget(env);

            logPersistenceData(env);
        } catch (final Exception ex) {
            log.warn("There was a problem logging data on startup", ex);
        }

        log.info("============================================================================");
    }

    // UTIL

    private void logEnvTarget(final Environment environment) {
        final String envTarget = getValueOfProperty(environment, ENV_TARGET_KEY, "local", Arrays.asList("local", "dev", "beta"));
        log.info("{} = {}", ENV_TARGET_KEY, envTarget);
    }

    private void logPersistenceTarget(final Environment environment) {
        final String envTarget = getValueOfProperty(environment, PERSISTENCE_TARGET_KEY, "h2", Arrays.asList("h2", "mysql", "mariadb"));
        log.info("{} = {}", PERSISTENCE_TARGET_KEY, envTarget);
    }

    private void logPersistenceData(final Environment environment) {
        final String persistenceHost = getValueOfProperty(environment, PERSISTENCE_HOST_KEY, "not-found", null);
        log.info("{} = {}", PERSISTENCE_HOST_KEY, persistenceHost);
    }

    //

    private final String getValueOfProperty(final Environment environment, final String propertyKey, final String propertyDefaultValue, final List<String> acceptablePropertyValues) {
        String propValue = environment.getProperty(propertyKey);
        if (propValue == null) {
            propValue = propertyDefaultValue;
            log.info("The {} doesn't have an explicit value; default value is = {}", propertyKey, propertyDefaultValue);
        }

        if (acceptablePropertyValues != null) {
            if (!acceptablePropertyValues.contains(propValue)) {
                log.warn("The property = {} has an invalid value = {}", propertyKey, propValue);
            }
        }

        if (propValue == null) {
            log.warn("The property = {} is null", propertyKey);
        }

        return propValue;
    }
}
