package com.sample;

import com.netflix.spinnaker.kork.plugins.api.spring.PrivilegedSpringPlugin;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;


public class ClouddriverPlugin extends PrivilegedSpringPlugin{

    public ClouddriverPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void registerBeanDefinitions(BeanDefinitionRegistry registry) {
        BeanDefinition sampleDef = beanDefinitionFor(SampleDefinition.class);
        try {
            log.debug("Registering bean: {}", sampleDef.getBeanClassName());
            registry.registerBeanDefinition("sampleDef", sampleDef);
        } catch (BeanDefinitionStoreException e) {
            log.error("Could not register bean {}", sampleDef.getBeanClassName());
        }

    }

    @Override
    public void start() {
        log.info("{} plugin started ******************************************", this.getClass().getSimpleName());
    }

    @Override
    public void stop() {
        log.info("{} plugin stopped******************************************", this.getClass().getSimpleName());
    }

}
