package org.example.bootstrap;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import org.example.user.User;
import org.example.useridcard.UserIdCard;
import org.hibernate.SessionFactory;

public class MyAppModule extends AbstractModule {
    private final HibernateBundle<MainConfiguration> hibernateBundle = new HibernateBundle<MainConfiguration>(
            User.class,
            UserIdCard.class
    ) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(MainConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public MyAppModule(Bootstrap<MainConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    protected void configure() {
    }

    @Provides
    public SessionFactory provideSessionFactory() {
        return hibernateBundle.getSessionFactory();
    }
}
