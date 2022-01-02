-- 테이블 생성
create table tblBook(
  bookTitle     VARCHAR2(50),
  bookWriter    varchar2(20),
  bookIsbn      varchar2(20) PRIMARY KEY not null,
  bookCompany   varchar2(20),
  bookCost      NUMBER,
  bookQty       number,
  bookPrice     number
);


-- 전체 레코드 검색
select * from tblbook;