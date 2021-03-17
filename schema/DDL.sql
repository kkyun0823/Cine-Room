--��ȭ���̺�
CREATE TABLE Movie (
	movie_no	INT NOT NULL CONSTRAINT PK_MOVIE PRIMARY KEY,
	genre_no	INT NOT NULL CONSTRAINT FK_MOVIE REFERENCES GENRE(GENRE_NO),
	movie_title	varchar2(100)	NOT NULL,
	release_date	date	NOT NULL,
	running_time	number	NOT NULL,
	movie_state	int default 1 NOT NULL,
	movie_director	varchar(50)	 NOT NULL
);

--�帣 ���̺�
CREATE TABLE Genre (
	genre_no	INT	NOT NULL CONSTRAINT PK_GENRE PRIMARY KEY,
	genre_name	varchar2(50)	NOT NULL
);
--�帣 ������
CREATE SEQUENCE GENRE_SEQ;
--�帣 ������ ����
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '�׼�');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '�ڹ̵�');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '�θǽ�');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '����');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '�ִϸ��̼�');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, 'SF');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '��Ÿ��');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '����');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '����');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '������');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '��ť���͸�');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '���');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '������/����');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '����');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '����');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '�̽��͸�');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '���');
INSERT INTO GENRE VALUES(GENRE_SEQ.NEXTVAL, '��Ÿ');

--ȸ�����̺�
CREATE TABLE Member (
	member_id	varchar(50)	NOT NULL CONSTRAINT PK_MEMBER PRIMARY KEY,
	member_password	varchar2(50)	NOT NULL,
	member_name	varchar2(20)	NOT NULL,
	member_birth	varchar2(30)	NOT NULL,
	member_state	int	 DEFAULT 1 NOT NULL
);
--��� ���̺�
CREATE TABLE Actor (
	actor_no	INT 	NOT NULL CONSTRAINT PK_ACTOR PRIMARY KEY,
	movie_no	INT 	NOT NULL CONSTRAINT FK_ACTOR REFERENCES MOVIE(MOVIE_NO),
	actor_name	varchar2(100)	NOT NULL
);
--���� ���̺�
CREATE TABLE Rate (
	rate_no	INT	NOT NULL CONSTRAINT PK_RATE PRIMARY KEY,
	member_id	VARCHAR2(50)	NOT NULL CONSTRAINT FK_RATE_MEMBER REFERENCES MEMBER(MEMBER_ID),
	movie_no	INT	NOT NULL CONSTRAINT FK_RATE_MOVIE REFERENCES MOVIE(MOVIE_NO),
	rate	number	NULL
);
--�Խ��� ���̺�
CREATE TABLE Board (
	board_no	INT NOT NULL CONSTRAINT PK_BOARD PRIMARY KEY,
	member_id	VARCHAR2(50)	NOT NULL CONSTRAINT FK_BOARD_MEMBER REFERENCES MEMBER(MEMBER_ID),
	movie_no	INT	NOT NULL CONSTRAINT FK_BOARD_MOVIE REFERENCES MOVIE(MOVIE_NO),
	board_title	varchar2(100)	NOT NULL,
	board_content	varchar2(500)	 NOT NULL,
	board_date date DEFAULT SYSDATE NOT NULL
);
--�Խ��� ������ ����
CREATE SEQUENCE BOARD_SEQ;
--��� ���̺�
CREATE TABLE Comments (
	comments_no INT	NOT NULL CONSTRAINT PK_COMMENT PRIMARY KEY,
	board_no	INT	NOT NULL CONSTRAINT FK_COMMENT_BOARD REFERENCES BOARD(BOARD_NO),
	member_id	VARCHAR2(50)	NOT NULL CONSTRAINT FK_COMMENT_MEMBER REFERENCES MEMBER(MEMBER_ID),
	comments_content	varchar2(500) NOT NULL,
	comments_date	date	DEFAULT SYSDATE NOT NULL
);
--��� ������ ����
CREATE SEQUENCE COMMENTS_SEQ;
--ȸ���� ��ȣ�帣 ���� ���̺�
CREATE TABLE Member_Genre (
	genre_favor_no	INT	NOT NULL CONSTRAINT PK_MEMBER_GENRE PRIMARY KEY,
	genre_no 	INT	NOT NULL CONSTRAINT FK_MEMBER_GENRE_NO REFERENCES GENRE(GENRE_NO),
	member_id	varchar2(50)	NOT NULL CONSTRAINT FK_MEMBER_GENRE_ID REFERENCES MEMBER(MEMBER_ID)
);
--���� ������ ����
CREATE SEQUENCE MEMBER_GENRE_SEQ;