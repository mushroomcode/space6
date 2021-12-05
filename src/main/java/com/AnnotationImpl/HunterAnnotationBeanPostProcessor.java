package com.AnnotationImpl;

import com.Annatations.HunterValueAnno;
import com.DiffBean.HunterCarParam;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 *  bean 實例化之前/之後
 */
@Component
public class HunterAnnotationBeanPostProcessor  implements BeanPostProcessor {

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        /**
         * 利用Java反射机制注入属性
         */
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            HunterValueAnno annotation = declaredField.getAnnotation(HunterValueAnno.class);
            // 進行 null 的判斷
            if (null == annotation) {
                continue;
            }
            // 注意 setAccessible 的值, 先設置
            declaredField.setAccessible(true);
            try {
                declaredField.set(bean, annotation.param());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}