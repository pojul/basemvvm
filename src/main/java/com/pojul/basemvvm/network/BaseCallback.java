package com.pojul.basemvvm.network;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseCallback<B> {

    public Type type;
    public Class<B> classType;

    public BaseCallback() {
        Type superClass = getClass().getGenericSuperclass();
        this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        if (this.type instanceof ParameterizedType) {
            this.classType = (Class<B>) ((ParameterizedType) this.type).getRawType();
        } else {
            this.classType = (Class<B>) this.type;
        }
    }

    public abstract void onSuccess(B resp);

    public abstract void onerror(String error);

}
