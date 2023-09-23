package jedis.sandbox;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Inject;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import redis.clients.jedis.Jedis;

@Command
@Introspected
public class JedisSandboxCommand implements Runnable {
  @Inject
  private Jedis jedis;

  public static void main(String[] args) {
    PicocliRunner.run(JedisSandboxCommand.class, args);
  }

  public void run() {
    System.out.println(jedis.info("server"));
  }
}
