--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.4

-- Started on 2022-12-28 10:15:09 +04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 219 (class 1255 OID 17437)
-- Name: id_books(character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.id_books(ad character varying) RETURNS real
    LANGUAGE plpgsql
    AS $$
declare
	primer real;
begin
	select id into primer
	from "public".books
	where name_books = ad;
	return primer;
end;
$$;


ALTER FUNCTION public.id_books(ad character varying) OWNER TO postgres;

--
-- TOC entry 220 (class 1255 OID 17438)
-- Name: id_readers(character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.id_readers(ad character varying) RETURNS real
    LANGUAGE plpgsql
    AS $$
declare
	primer real;
begin
	select id into primer
	from public.readers
	where name_readers = ad;
	return primer;
end;
$$;


ALTER FUNCTION public.id_readers(ad character varying) OWNER TO postgres;

--
-- TOC entry 218 (class 1255 OID 17426)
-- Name: id_title_topic(character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.id_title_topic(ad character varying) RETURNS real
    LANGUAGE plpgsql
    AS $$
declare
	primer real;
begin
	select id into primer
	from "public".topics
	where title_topics = ad;
	return primer;
end;
$$;


ALTER FUNCTION public.id_title_topic(ad character varying) OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 17367)
-- Name: books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.books (
    id_libraries integer NOT NULL,
    id integer NOT NULL,
    id_topics integer NOT NULL,
    author character varying(255) NOT NULL,
    name_books character varying(255) NOT NULL,
    publishers character varying(255) NOT NULL,
    year_books character varying(255) NOT NULL,
    quantity_books integer NOT NULL
);


ALTER TABLE public.books OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 17366)
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.books_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.books_id_seq OWNER TO postgres;

--
-- TOC entry 3623 (class 0 OID 0)
-- Dependencies: 213
-- Name: books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;


--
-- TOC entry 210 (class 1259 OID 17346)
-- Name: libraries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libraries (
    id integer NOT NULL,
    title character varying(255),
    address character varying(255)
);


ALTER TABLE public.libraries OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 17345)
-- Name: libraries_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.libraries_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.libraries_id_seq OWNER TO postgres;

--
-- TOC entry 3624 (class 0 OID 0)
-- Dependencies: 209
-- Name: libraries_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.libraries_id_seq OWNED BY public.libraries.id;


--
-- TOC entry 216 (class 1259 OID 17386)
-- Name: readers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.readers (
    id integer NOT NULL,
    name_readers character varying(255) NOT NULL,
    address character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);


ALTER TABLE public.readers OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 17385)
-- Name: readers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.readers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.readers_id_seq OWNER TO postgres;

--
-- TOC entry 3625 (class 0 OID 0)
-- Dependencies: 215
-- Name: readers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.readers_id_seq OWNED BY public.readers.id;


--
-- TOC entry 217 (class 1259 OID 17394)
-- Name: season_ticket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.season_ticket (
    id_libraries integer NOT NULL,
    id_books integer NOT NULL,
    id_readers integer NOT NULL,
    date_of_issue timestamp without time zone NOT NULL,
    date_return timestamp without time zone
);


ALTER TABLE public.season_ticket OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 17360)
-- Name: topics; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topics (
    id integer NOT NULL,
    title_topics character varying(255)
);


ALTER TABLE public.topics OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 17359)
-- Name: topics_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topics_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topics_id_seq OWNER TO postgres;

--
-- TOC entry 3626 (class 0 OID 0)
-- Dependencies: 211
-- Name: topics_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topics_id_seq OWNED BY public.topics.id;


--
-- TOC entry 3455 (class 2604 OID 17370)
-- Name: books id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);


--
-- TOC entry 3453 (class 2604 OID 17349)
-- Name: libraries id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libraries ALTER COLUMN id SET DEFAULT nextval('public.libraries_id_seq'::regclass);


--
-- TOC entry 3456 (class 2604 OID 17389)
-- Name: readers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.readers ALTER COLUMN id SET DEFAULT nextval('public.readers_id_seq'::regclass);


--
-- TOC entry 3454 (class 2604 OID 17363)
-- Name: topics id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topics ALTER COLUMN id SET DEFAULT nextval('public.topics_id_seq'::regclass);


--
-- TOC entry 3614 (class 0 OID 17367)
-- Dependencies: 214
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.books (id_libraries, id, id_topics, author, name_books, publishers, year_books, quantity_books) VALUES (10842021, 24, 3, 'Дэвид Томас', 'Программист-прагматик', 'Вильямс', '2020', 2);
INSERT INTO public.books (id_libraries, id, id_topics, author, name_books, publishers, year_books, quantity_books) VALUES (10842021, 25, 3, 'Герберт Шилдт', 'Java. Полное руководство', 'Диалектика-Вильямс', '2018', 1);
INSERT INTO public.books (id_libraries, id, id_topics, author, name_books, publishers, year_books, quantity_books) VALUES (10842021, 28, 4, 'Рогов', 'PostgreSQL изнутри', 'ДМК Пресс', '2022', 2);


--
-- TOC entry 3610 (class 0 OID 17346)
-- Dependencies: 210
-- Data for Name: libraries; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.libraries (id, title, address) VALUES (10842021, 'Научная библиотека ИжГТУ', 'Студенческая ул., 7');


--
-- TOC entry 3616 (class 0 OID 17386)
-- Dependencies: 216
-- Data for Name: readers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.readers (id, name_readers, address, phone) VALUES (9, 'Сальников Никита Денисович', 'Ижевск Ворошилова 37', '89120033010');


--
-- TOC entry 3617 (class 0 OID 17394)
-- Dependencies: 217
-- Data for Name: season_ticket; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.season_ticket (id_libraries, id_books, id_readers, date_of_issue, date_return) VALUES (10842021, 25, 9, '2022-12-27 23:30:14.522154', NULL);
INSERT INTO public.season_ticket (id_libraries, id_books, id_readers, date_of_issue, date_return) VALUES (10842021, 28, 9, '2022-12-27 23:30:33.816148', '2022-12-27 23:33:52.730995');


--
-- TOC entry 3612 (class 0 OID 17360)
-- Dependencies: 212
-- Data for Name: topics; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.topics (id, title_topics) VALUES (3, 'Программирование');
INSERT INTO public.topics (id, title_topics) VALUES (4, 'Базы данных');
INSERT INTO public.topics (id, title_topics) VALUES (5, 'Кулинария');
INSERT INTO public.topics (id, title_topics) VALUES (6, 'Графика, дизайн, верстка');
INSERT INTO public.topics (id, title_topics) VALUES (7, 'Экономика');


--
-- TOC entry 3627 (class 0 OID 0)
-- Dependencies: 213
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.books_id_seq', 28, true);


--
-- TOC entry 3628 (class 0 OID 0)
-- Dependencies: 209
-- Name: libraries_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.libraries_id_seq', 17, true);


--
-- TOC entry 3629 (class 0 OID 0)
-- Dependencies: 215
-- Name: readers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.readers_id_seq', 9, true);


--
-- TOC entry 3630 (class 0 OID 0)
-- Dependencies: 211
-- Name: topics_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topics_id_seq', 7, true);


--
-- TOC entry 3462 (class 2606 OID 17374)
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


--
-- TOC entry 3458 (class 2606 OID 17353)
-- Name: libraries libraries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libraries
    ADD CONSTRAINT libraries_pkey PRIMARY KEY (id);


--
-- TOC entry 3464 (class 2606 OID 17393)
-- Name: readers readers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.readers
    ADD CONSTRAINT readers_pkey PRIMARY KEY (id);


--
-- TOC entry 3460 (class 2606 OID 17365)
-- Name: topics topics_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topics
    ADD CONSTRAINT topics_pkey PRIMARY KEY (id);


--
-- TOC entry 3465 (class 2606 OID 17375)
-- Name: books books_id_libraries_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_id_libraries_fkey FOREIGN KEY (id_libraries) REFERENCES public.libraries(id);


--
-- TOC entry 3466 (class 2606 OID 17380)
-- Name: books books_id_topics_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_id_topics_fkey FOREIGN KEY (id_topics) REFERENCES public.topics(id);


--
-- TOC entry 3468 (class 2606 OID 17402)
-- Name: season_ticket season_ticket_id_books_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.season_ticket
    ADD CONSTRAINT season_ticket_id_books_fkey FOREIGN KEY (id_books) REFERENCES public.books(id);


--
-- TOC entry 3467 (class 2606 OID 17397)
-- Name: season_ticket season_ticket_id_libraries_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.season_ticket
    ADD CONSTRAINT season_ticket_id_libraries_fkey FOREIGN KEY (id_libraries) REFERENCES public.libraries(id);


--
-- TOC entry 3469 (class 2606 OID 17407)
-- Name: season_ticket season_ticket_id_readers_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.season_ticket
    ADD CONSTRAINT season_ticket_id_readers_fkey FOREIGN KEY (id_readers) REFERENCES public.readers(id);


-- Completed on 2022-12-28 10:15:09 +04

--
-- PostgreSQL database dump complete
--

