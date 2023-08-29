* 모든 작업은 DBA(root)로 한다.
```sh
# mysql -u root -p
```

1. 데이터 베이스 생성
```sh
MariaDB [(none)]> create database webdb;
MariaDB [(none)]> show databases;
```

2. 사용자 생성 : ip가 바뀌지 않는다면 'localhost'로 사용 가능
```sh
MariaDB [(none)]> create user 'webdb'@'192.168.%' identified by '비밀번호(webdb)';
```

3. 권한부여
```sh
MariaDB [(none)]> grant all privileges on webdb.* to 'webdb'@'192.168.%';
MariaDB [(none)]> flush privileges;
```

4. 확익하기
```sh
# mysql -u webdb -D webdb -p
password:
MariaDB [webdb]> 
```