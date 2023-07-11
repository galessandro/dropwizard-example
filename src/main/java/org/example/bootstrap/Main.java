package org.example.bootstrap;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class Main extends Application<MainConfiguration> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void initialize(Bootstrap<MainConfiguration> bootstrap) {
        bootstrap.addBundle(
                GuiceBundle
                        .builder()
                        .modules(new MyAppModule(bootstrap))
                        .enableAutoConfig("org.example")
                        .build());
    }

    @Override
    public void run(MainConfiguration mainConfiguration,
                    Environment environment) {
    }

}