package origin.link;

import org.junit.jupiter.api.Test;

public class LinkingSample {

    static class Human {}

    static class Man extends Human {}

    static class Woman extends Human {}

    static void staticSay(Human human) {
        System.out.println("Human");
    }

    static void staticSay(Man man) {
        System.out.println("Man");
    }

    static void staticSay(Woman woman) {
        System.out.println("Woman");
    }

    void say(Human human) {
        System.out.println("Human");
    }

    void say(Man man) {
        System.out.println("Man");
    }

    void say(Woman woman) {
        System.out.println("Woman");
    }

    @Test
    void dynamicLink() {
        // given
        Human man = new Man();
        Human woman = new Woman();

        // when & then
        say(man);
        say(woman);

        LinkingSample linkingSample = new LinkingSample();
        linkingSample.say(man);
        linkingSample.say(woman);
    }
}
