package redisson.sandbox;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Factory
public class RedisFactory {

  @Singleton
  public RedissonClient newRedisson(
      @NotBlank @Value("${infrastructure.redis.host}") String host,
      @NotNull @Value("${infrastructure.redis.port}") Integer port
  ) {
    Config config = new Config();

    config.useSingleServer()
        .setPingConnectionInterval(60_000)
        .setDatabase(0)
        .setConnectionMinimumIdleSize(1)
        .setConnectionPoolSize(100)
        .setAddress("redis://" + host + ":" + port);

    return Redisson.create(config);
  }
}
