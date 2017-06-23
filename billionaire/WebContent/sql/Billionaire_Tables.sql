create schema account;

create sequence account.user_id_seq;
create sequence account.daily_budget_id_seq;
create sequence account.additional_income_id_seq;
create sequence account.savings_performance_id_seq;
create sequence account.expense_id_seq;
create sequence account.fixed_cost_id_seq;
create sequence account.savings_goal_id_seq;
create sequence account.income_id_seq;
create sequence account.balance_id_seq;

CREATE TABLE account.user (
	id integer DEFAULT nextval('account.user_id_seq') NOT NULL,
	name varchar(50) NOT NULL,
	password varchar(15) NOT NULL,
	mail varchar(40) NOT NULL,
	created_at timestamp without time zone DEFAULT now() NOT NULL
)
;

CREATE TABLE account.expense_category (
	type varchar(30) NOT NULL,
	name varchar(30) NOT NULL
)
;

CREATE TABLE account.daily_budget (
	id integer DEFAULT nextval('account.daily_budget_id_seq') NOT NULL,
	user_id integer NOT NULL,
	date date NOT NULL,
	budget integer NOT NULL,
	created_at timestamp without time zone DEFAULT now() NOT NULL
)
;

CREATE TABLE account.additional_income (
	id integer DEFAULT nextval('account.additional_income_id_seq') NOT NULL,
	user_id integer NOT NULL,
	name varchar(50),
	amount integer NOT NULL,
	add_date timestamp without time zone DEFAULT now() NOT NULL,
	created_at timestamp without time zone DEFAULT now() NOT NULL
)
;

CREATE TABLE account.savings_performance (
	id integer DEFAULT nextval('account.savings_performance_id_seq') NOT NULL,
	user_id integer NOT NULL,
	revenue_month date NOT NULL,
	amount integer NOT NULL,
	savings_goal_amount integer NOT NULL,
	created_at timestamp without time zone DEFAULT now() NOT NULL
)
;

CREATE TABLE account.expense (
	id integer DEFAULT nextval('account.expense_id_seq') NOT NULL,
	daily_budget_id integer NOT NULL,
	category_type varchar(30) NOT NULL,
	name varchar(30),
	amount integer NOT NULL,
	memo varchar(100),
	created_at timestamp without time zone DEFAULT now() NOT NULL
)
;

CREATE TABLE account.fixed_cost (
	id integer DEFAULT nextval('account.fixed_cost_id_seq') NOT NULL,
	user_id integer NOT NULL,
	name varchar(50) NOT NULL,
	amount integer NOT NULL,
	created_at timestamp without time zone DEFAULT now() NOT NULL
)
;

CREATE TABLE account.savings_goal (
	id integer DEFAULT nextval('account.savings_goal_id_seq') NOT NULL,
	user_id integer NOT NULL,
	amount integer NOT NULL,
	created_at timestamp without time zone DEFAULT now() NOT NULL
)
;

CREATE TABLE account.income (
	id integer DEFAULT nextval('account.income_id_seq') NOT NULL,
	user_id integer NOT NULL,
	amount integer NOT NULL,
	revenue_date integer NOT NULL,
	created_at timestamp without time zone DEFAULT now() NOT NULL
)
;

CREATE TABLE account.balance (
	id integer DEFAULT nextval('account.balance_id_seq') NOT NULL,
	user_id integer NOT NULL,
	month integer NOT NULL,
	amount integer NOT NULL,
	created_at timestamp without time zone DEFAULT now() NOT NULL
)
;


ALTER TABLE account.user
	ADD CONSTRAINT UQ_user_mail UNIQUE (mail)
;
ALTER TABLE account.savings_goal
	ADD CONSTRAINT UQ_savings_goal_user_id UNIQUE (user_id)
;
ALTER TABLE account.income
	ADD CONSTRAINT UQ_income_user_id UNIQUE (user_id)
;
ALTER TABLE account.balance
	ADD CONSTRAINT UQ_balance_user_id UNIQUE (user_id)
;
ALTER TABLE account.user ADD CONSTRAINT PK_user
	PRIMARY KEY (id)
;


ALTER TABLE account.expense_category ADD CONSTRAINT PK_category
	PRIMARY KEY (type)
;


ALTER TABLE account.daily_budget ADD CONSTRAINT PK_daily_budget
	PRIMARY KEY (id)
;


ALTER TABLE account.additional_income ADD CONSTRAINT PK_additional_income
	PRIMARY KEY (id)
;


ALTER TABLE account.savings_performance ADD CONSTRAINT PK_performance
	PRIMARY KEY (id)
;


ALTER TABLE account.expense ADD CONSTRAINT PK_expense
	PRIMARY KEY (id)
;


ALTER TABLE account.fixed_cost ADD CONSTRAINT PK_fixed_cost
	PRIMARY KEY (id)
;


ALTER TABLE account.savings_goal ADD CONSTRAINT PK_savings
	PRIMARY KEY (id)
;


ALTER TABLE account.income ADD CONSTRAINT PK_income
	PRIMARY KEY (id)
;


ALTER TABLE account.balance ADD CONSTRAINT PK_balance
	PRIMARY KEY (id)
;




ALTER TABLE account.daily_budget ADD CONSTRAINT FK_daily_budget_user
	FOREIGN KEY (user_id) REFERENCES account.user (id)
;

ALTER TABLE account.additional_income ADD CONSTRAINT FK_additional_income_user
	FOREIGN KEY (user_id) REFERENCES account.user (id)
;

ALTER TABLE account.savings_performance ADD CONSTRAINT FK_performance_user
	FOREIGN KEY (user_id) REFERENCES account.user (id)
;

ALTER TABLE account.expense ADD CONSTRAINT FK_expense_category
	FOREIGN KEY (category_type) REFERENCES account.expense_category (type)
;

ALTER TABLE account.expense ADD CONSTRAINT FK_expense_daily_budget
	FOREIGN KEY (daily_budget_id) REFERENCES account.daily_budget (id)
;

ALTER TABLE account.fixed_cost ADD CONSTRAINT FK_fixed_cost_user
	FOREIGN KEY (user_id) REFERENCES account.user (id)
;

ALTER TABLE account.savings_goal ADD CONSTRAINT FK_savings_user
	FOREIGN KEY (user_id) REFERENCES account.user (id)
;

ALTER TABLE account.income ADD CONSTRAINT FK_income_user
	FOREIGN KEY (user_id) REFERENCES account.user (id)
;

ALTER TABLE account.balance ADD CONSTRAINT FK_balance_user
	FOREIGN KEY (user_id) REFERENCES account.user (id)
;
