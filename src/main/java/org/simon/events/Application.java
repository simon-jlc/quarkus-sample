package org.simon.events;


import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.simon.events.domain.Asset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class Application {

    @Inject
    EntityManager manager;

    private static final Logger LOGGER = LoggerFactory.getLogger("ListenerBean");

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }

    public void hello() {
        LOGGER.warn("hello");
    }

    @Transactional
    public void createAsset() {
        new Asset("test-1", LocalDate.now()).persist();
    }

    @Transactional
    public List<Asset> findAll() {
        return Asset.listAll();
    }
}
