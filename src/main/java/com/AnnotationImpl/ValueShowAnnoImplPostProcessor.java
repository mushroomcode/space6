package com.AnnotationImpl;

import com.Annatations.ValueShowAnno;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.util.Set;

// 后置加载处理
@Component
public class ValueShowAnnoImplPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        ClassPathScanningCandidateComponentProvider classPathScanningCandidateComponentProvider = new ClassPathScanningCandidateComponentProvider(false);
        classPathScanningCandidateComponentProvider.addIncludeFilter(new AnnotationTypeFilter(ValueShowAnno.class));
        Set<BeanDefinition> set =  classPathScanningCandidateComponentProvider.findCandidateComponents("com.Annotation");
        for(BeanDefinition i : set) {
            beanDefinitionRegistry.registerBeanDefinition(i.getBeanClassName(), i);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}