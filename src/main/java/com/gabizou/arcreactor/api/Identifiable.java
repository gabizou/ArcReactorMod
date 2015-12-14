package com.gabizou.arcreactor.api;

/**
 * Provides as an identifiable "type", can be an energy source, acceptor,
 * cable, etc. so long as it remains configurable and identifiable by id.
 */
public interface Identifiable {

    String getTypeId();

}
