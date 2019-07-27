package util.environment;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})

public interface EnvironmentConf extends Config {

  String url();
  String sergey();
  String url_get_token();
}
