package main.works;

public interface WorkInterface {
	String getName();
	default boolean isProgress() { return false; };
 	default void progress() {
        System.out.println("------------------------");
		System.out.println(getName()+" 업무를 시작합니다.");
 	};
	default void update() {
		while(isProgress()){
			progress();
		}
	}
}