package redisson.sandbox;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Inject;
import org.redisson.api.RedissonClient;
import picocli.CommandLine.Command;

@Command
@Introspected
public class RedissonDemo implements Runnable {
  @Inject
  private RedissonClient redisson;

  public static void main(String[] args) {
    PicocliRunner.run(RedissonDemo.class, args);
  }

  public void run() {
    System.out.println("Counted keys: " + redisson.getKeys().count());
    redisson.getKeys().getKeysByPattern("actor:*", 5).forEach(item -> {});
  }
}
