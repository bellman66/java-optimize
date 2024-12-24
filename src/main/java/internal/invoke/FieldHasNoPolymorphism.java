package internal.invoke;

public class FieldHasNoPolymorphism {

    static class Parent {

        public int value = 1;

        Parent() {
            this.value = 2;
            printValue();
        }

        // Son의 printValue를 InvokeVirtual로 호출
        // Son의 Field값이 초기화 전이기에 0이 호출됨.
        public void printValue() {
            System.out.println("Parent = " + value);
        }
    }

    static class Son extends Parent {

        public int value = 3;

        Son() {
            this.value = 4;
            printValue();
        }

        // Execute InvokeVirtual
        public void printValue() {
            System.out.println("Son = " + value);
        }
    }

    public static void main(String[] args) {
        Parent parent = new Son();
        System.out.println("parent = " + parent.value);
    }
}
