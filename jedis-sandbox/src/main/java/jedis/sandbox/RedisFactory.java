package jedis.sandbox;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import redis.clients.jedis.Jedis;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Factory
public class RedisFactory {

  @Singleton
  public Jedis newRedisClient(
      @NotBlank @Value("${infrastructure.redis.host}") String host,
      @NotNull @Value("${infrastructure.redis.port}") Integer port
  ) {
    return new Jedis(host, port);
  }


}
