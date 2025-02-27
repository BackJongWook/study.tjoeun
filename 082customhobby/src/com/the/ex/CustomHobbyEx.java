package com.the.ex;

import com.the.dao.CustomerDao;
import com.the.dao.HobbyDao;
import com.the.dto.CustomerDto;
import com.the.dto.HobbyDto;
import com.the.util.UserInput;

import java.util.ArrayList;

public class CustomHobbyEx {
    private static CustomerDao customerDao = new CustomerDao();
    private static HobbyDao hobbyDao = new HobbyDao();
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== 고객 및 취미 관리 시스템 =====");
            System.out.println("1. 고객 추가");
            System.out.println("2. 고객 목록 조회");
            System.out.println("3. 고객 삭제");
            System.out.println("4. 고객 정보 수정");
            System.out.println("5. 취미 추가");
            System.out.println("6. 취미 목록 조회");
            System.out.println("7. 취미 삭제");
            System.out.println("8. 취미 수정");
            System.out.println("0. 종료");
            
            int choice = UserInput.inputInt("메뉴 선택");
            switch (choice) {
                case 1: addCustomer(); break;
                case 2: listCustomers(); break;
                case 3: deleteCustomer(); break;
                case 4: updateCustomer(); break;
                case 5: addHobby(); break;
                case 6: listHobbies(); break;
                case 7: deleteHobby(); break;
                case 8: updateHobby(); break;
                case 0: System.out.println("프로그램을 종료합니다."); return;
                default: System.out.println("올바른 메뉴를 선택하세요.");
            }
        }
    }

    private static void addCustomer() {
        String name = UserInput.inputString("이름");
        int age = UserInput.inputInt("나이");
        double height = UserInput.inputDouble("키");
        var birthday = UserInput.inputLocalDateTime("생년월일");
        customerDao.insert(new CustomerDto(null, name, age, height, birthday));
        System.out.println("고객이 추가되었습니다.");
    }

    private static void listCustomers() {
        ArrayList<CustomerDto> customers = customerDao.selectAll();
        if (customers.isEmpty()) {
            System.out.println("등록된 고객이 없습니다.");
            return;
        }
        customers.forEach(c -> System.out.printf("ID: %d | 이름: %s | 나이: %d | 키: %.2f | 생년월일: %s\n",
                c.getId(), c.getName(), c.getAge(), c.getHeight(), UserInput.dateToString(c.getBirthday())));
    }

    private static void deleteCustomer() {
        long id = UserInput.inputInt("삭제할 고객 ID");
        customerDao.delete(id);
        System.out.println("고객이 삭제되었습니다.");
    }

    private static void updateCustomer() {
        long id = UserInput.inputInt("수정할 고객 ID");
        String name = UserInput.inputString("새 이름");
        int age = UserInput.inputInt("새 나이");
        double height = UserInput.inputDouble("새 키");
        var birthday = UserInput.inputLocalDateTime("새 생년월일");
        customerDao.update(id, name, age, height, UserInput.dateToString(birthday));
        System.out.println("고객 정보가 수정되었습니다.");
    }

    private static void addHobby() {
        long customerId = UserInput.inputInt("고객 ID");
        String hobby = UserInput.inputString("추가할 취미");
        hobbyDao.insert(new HobbyDto(null, customerId, hobby));
        System.out.println("취미가 추가되었습니다.");
    }

    private static void listHobbies() {
        ArrayList<HobbyDto> hobbies = hobbyDao.selectAll();
        if (hobbies.isEmpty()) {
            System.out.println("등록된 취미가 없습니다.");
            return;
        }
        hobbies.forEach(h -> System.out.printf("ID: %d | 고객 ID: %d | 취미: %s\n",
                h.getId(), h.getCustomerId(), h.getHobby()));
    }

    private static void deleteHobby() {
        long id = UserInput.inputInt("삭제할 취미 ID");
        hobbyDao.delete(id);
        System.out.println("취미가 삭제되었습니다.");
    }

    private static void updateHobby() {
        long id = UserInput.inputInt("수정할 취미 ID");
        String newHobby = UserInput.inputString("새로운 취미");
        hobbyDao.update(id, newHobby);
        System.out.println("취미가 수정되었습니다.");
    }
}
