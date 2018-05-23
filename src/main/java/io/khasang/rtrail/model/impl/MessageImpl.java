package io.khasang.rtrail.model.impl;

import io.khasang.rtrail.model.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("message")
//@Scope("singleton") // scope - область видимости (по умолчанию singleton), т.е. наш контейнер спринга создаст единственный экземпляр бина - 99%
//@Scope("prototype") // наш контейнер спринга будет создавать любое количество экземпляров бина, когда это необходимо (getBean) - встречается очень редко
//@Scope("request") // жизненный цикл экземпляра ограничен единственным http запросом - практически не встречается
//@Scope("session") // жизненный цикл нашего экземпляра будет ограничен в пределах одной http сессии
//@Scope("global session") // жизненный цикл нашего экземпляра будет ограничен в пределах глобальной http сессии
//@Scope("application") // жизненный цикл экземпляра ограничен в пределах сервлет контекста

@Component
@Lazy // подгрузка класса только в момент обращения к нему (актуально для редко используемых компонентов)
@Qualifier("main") // уточняем как мы можем обращаться к данному бину
public class MessageImpl implements Message {
    public MessageImpl() {
    }

    private String name;

    public MessageImpl(String name) {
        this.name = name;
    }

    @PostConstruct
    public void start() {
        System.out.println("Starting...");
    }

    @PreDestroy
    public void clean() {
        System.out.println("Ending...");
    }

    @Override
    public String getInfo() {
        return "new Bean World!";
    }

    @Override
    public void setInfo(String info) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
