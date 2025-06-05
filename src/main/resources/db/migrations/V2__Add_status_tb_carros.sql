-- Migration para adicionar a coluna de status na tabela carros
ALTER TABLE tb_carros
ADD COLUMN status VARCHAR(255);