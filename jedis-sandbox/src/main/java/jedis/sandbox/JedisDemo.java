package jedis.sandbox;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import redis.clients.jedis.Jedis;

@Command
@Introspected
public class JedisDemo implements Runnable {
  @Inject
  private Jedis jedis;

  public static void main(String[] args) {
    PicocliRunner.run(JedisDemo.class, args);
  }

  public void run() {
    System.out.println(jedis.info("server"));
  }
}
