package com.socks.api;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

    @Key("{env}.baseUrl")
    String baseUrl();

    @DefaultValue("de")
    String locale();

    boolean logging();
}
