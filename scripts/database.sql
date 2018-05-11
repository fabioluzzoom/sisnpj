create table funcao (
    idfuncao     serial,
    descricao    varchar(50),
    interno      char(1),
    constraint pk_funcao primary key (idfuncao),
    constraint ck_funcao check (interno in ('I','E'))
    );
create table pessoa (
    idpessoa serial,
    cpf          varchar(20),
    nome         varchar(100),
    email        varchar(100),
    fone01       varchar(20),
    fone02       varchar(20),
    idfuncao     int,
    logradouro   varchar(100),
    numero       varchar(20),
    complemento  varchar(50),
    bairro       varchar(50),
    estado       char(2),
    municipio    varchar(50),
    cep          varchar(8),
    constraint pk_pessoa primary key (idpessoa),
    constraint fk_funcao foreign key (idfuncao) references funcao
    );
create table area (
    idarea       serial,
    descricao    varchar(50),
    constraint pk_area primary key (idarea)
    );
create table classifprocesso (
    idclassif   serial,
    idarea      int,
    descricao   varchar(100),
    constraint pk_classifproc primary key (idclassif),
    constraint fk_classifarea foreign key (idarea) references area
    );
    
create table processo (
    idprocesso serial,
    datahoraentrada      timestamp,
    vara                 varchar(50),
    numprocessovara      varchar(50),
    relatofato           varchar(6000),
    obsinicial           varchar(6000),
    obsfinal             varchar(6000),
    idsituacao           int,
    idclassif            int,
    constraint pk_processo     primary key (idprocesso),
    constraint fk_clissifproc  foreign key (idclassif) references classifprocesso
    );

create table formapart (
    idformapart serial,
    descricao   varchar(100),
    constraint pk_formapart primary key (idformapart)
    );
    
create table parte (
    idpessoa    int,
    idprocesso  int,
    idformapart int,
    constraint pk_parte primary key (idpessoa, idprocesso)
    );
    
create table tramitacao (
    idtramitacao     serial,
    datatramitacao   timestamp,
    textotramitacao  varchar(6000),
    idpessoa         int,
    constraint pk_tramitacao primary key (idtramitacao),
    constraint fk_tramitapessoa foreign key (idpessoa) references pessoa
    );
    
create table tipodoc (
    idtipodoc serial,
    descricao varchar(50),
    constraint pk_tipodoc primary key (idtipodoc)
    );

create table documentoproc (
    iddocumento  serial,
    idprocesso   int,
    idtipodoc    int,
    documento    bytea,
    constraint pk_documento primary key (iddocumento),
    constraint fk_docproc   foreign key (idprocesso) references processo,
    constraint fk_doctipo   foreign key (idtipodoc)  references tipodoc
    );
