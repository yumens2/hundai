# java-baseball-precourse

# 사용한 메서드
* to_be_continue()
*  정답을 맞추고 어떤 동작을 할지 결정
* find_same_number()
* 혹시 3개의 숫자중에 같은게 있나 판단
* find_zero()
* 3개의 숫자중에서 0이 있나 판단
* error_list()
* 에러 목록 전부 넣어서 에러가 하나라도 있으면 에러처리
* get_num()
* 플레이어에게 숫자를 입력받게 하는데 에러를 유발하면 바로 
예외처리하고 종료
* get_rand()
* 3개의 난수를 발생시킴. 만약 중복이 있으면 없을때까지 계속 난수 생성


# 사용한 클래스
* <멤버 변수>
* player_number;
* 플레이어의 숫자
* random_number;
* 난수 


* <멤버 메서드>
* make_array()
* 플레이어와 난수를 3자리의 자연수로 입력받았기 때문에
쪼개서 리스트에 담음
* compare()
* 혹시 같은 숫자가 있는지 판단
* add_strike()
* 각 조건에 따라서 strike , ball 에 카운트 1씩 해줌
* set_answer()
* 프로그램 종료를 main에 알려주기 위해서 100의 자리는 strike
10의 자리는 ball을 넣어서 3자리의 자연수로 반환함
* print_answer()
* 볼 카운트를 출력시킴.


