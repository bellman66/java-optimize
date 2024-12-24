package internal.invoke;

import java.util.List;

public class DoubleDispatch {

    interface Parent {
        void showSns(SNS sns);
    }

    static class Father implements Parent {

        public int value = 1;

        Father() {}

        public void showSns(SNS sns) {
            System.out.print("Father SNS : ");
            sns.print();
        }
    }

    static class Mother implements Parent {

        public int value = 2;

        Mother() {}

        // Method 파라미터 SNS에서 동적 디스패치
        public void showSns(SNS sns) {
            System.out.print("Mother SNS : ");
            sns.print();
        }
    }

    interface SNS {
        void print();
    }

    static class Twitter implements SNS {

        @Override
        public void print() {
            System.out.println("Twitter");
        }
    }

    static class FaceBook implements SNS {

        @Override
        public void print() {
            System.out.println("FaceBook");
        }
    }

    public static void main(String[] args) {
        List<Parent> parents = List.of(new Father(), new Mother());
        List<SNS> snsGroup = List.of(new Twitter(), new FaceBook());

        for (int i=0; i<2; i++) {
            Parent parent = parents.get(i);
            SNS sns = snsGroup.get(i);

            parent.showSns(sns);
        }
    }
}
