# Fastcam-Project1-Board-Server

git 사용법 숙지
1. git을 사용할 폴더에 가서 git init 하기
2. git 이메일 주소 주가 : git config user.email "@gmail.com"
3. git 사용자 명 추가 :  git config user.name "minihama"
4. git 에서 새로운 래포지토리 생성
5. git 레포지토리 주소 추가 : git remote add origin https://github.com/minihama/Fastcam-Project1-Board-Server.git
6. git commit 테스트 : git commit -m "first commit"
7. git push :  git push origin master
8. 사이트 로그인
9. push 확인
info: please complete authentication in your browser...
Enumerating objects: 29, done.
Counting objects: 100% (29/29), done.
Delta compression using up to 24 threads
Compressing objects: 100% (18/18), done.
Writing objects: 100% (29/29), 90.91 KiB | 10.10 MiB/s, done.
Total 29 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
remote:
remote: Create a pull request for 'master' on GitHub by visiting:
remote:      https://github.com/minihama/Fastcam-Project1-Board-Server/pull/new/master
remote:
To https://github.com/minihama/Fastcam-Project1-Board-Server.git
 * [new branch]      master -> master

10. master가 브랜치로 생성되고 "디폴트"로 사용 안되어 확인하여 변경
11. branch 이름을 변경 : git branch -M main
12. 확인 : git branch
13. git push : git push origin main <<에러 발생>>
14. 명령어 입력 : git pull origin main --allow-unrelated-histories
15. 다시 push : git push origin main
16. push 확인

lombok 익스텐션 설치
익스텐션 검색 : lombok annotations


사용자 API개발
1. MVC기반으로 project 추가
NewJAVAPackage -> controller
2. 사용자 api에 대한 개발을 위한 컨트롤러 명시
NewJAVAFile -> Class -> UserController
3. userservice 를 위한 페키지 설치 (인터페이스)
NewJAVAPackage -> service
NewJAVAFile -> Class -> UserService (클래스는 대뮨자로)
4. userdto에 사용할 패키지 설치
NewJAVAPackage -> dto
NewJAVAFile -> Class -> UserDTO
5. 임플리먼트 패키시 설치
NewJAVAPackage -> impl
NewJAVAFile -> Class -> UserServiceImpl
구현 메서드를 추가 
6. controller에 생성자 추가
7. DB와 통신하기 위한 컨트롤러 생성
NewJAVAPackage -> config
NewJAVAFile -> Class -> DataBaseConfig
NewJAVAFile -> Class -> MysqlConfig




수업 내용 모두 확인 하여 적용 완료 
붉은 색 문제 내역 처리 완료(10/22)

=======================================================
# mybatis-test-vscode

mybatis-mysl 연동을 위한 테스트 서버 구성
mybatis-test-vscode 동작 완료

=======================================================
