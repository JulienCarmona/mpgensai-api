package fr.mpgensai.common.service.impl;

import fr.mpgensai.common.model.IEntity;
import fr.mpgensai.common.service.IService;

public abstract class AbstractService<T extends IEntity> extends AbstractRawService<T> implements IService<T> {
}
