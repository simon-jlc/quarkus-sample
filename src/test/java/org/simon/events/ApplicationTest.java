package org.simon.events;

import io.quarkus.test.junit.QuarkusTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.simon.events.domain.Asset;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class ApplicationTest {

    @Inject
    Application app;

    @Test
    void name() {
        app.hello();
        app.createAsset();
        List<Asset> all = app.findAll();
        assertThat(all).hasSize(1);
    }
}