1. employees_dp.zip 다운로드 (xshell 새탭에서 진행)
```sh
# sftp webmaster@192.168.0.186
# cd /home/webmaster
# lcd C:\Dev
# put employees_db.zip
```

2. DB 백업 파일(employees_db.zip) 압축 풀기 (root 계정으로 진행)
```sh
# mv /home/webmaster/employees_db.zip /root
```

3. unzip 라이브러리 다운로드 및 zip 파일 압축 풀기
```sh
# yum -y install unzip
# unzip employees_db.zip
```

4. employees 데이터 베이스 생성 및 hr 계정 생성/권한 주기
```sh
# cd employees_db
# mysql -u root -p
# create database employees;
# create user 'hr'@'192.168.%' identified by 'hr';
# grant all privileges on employees.* to 'hr'@'192.168.%';
# flush privileges;
```

5. restore
```sh
# mysql -u root -D employees -p < employees.sql
```