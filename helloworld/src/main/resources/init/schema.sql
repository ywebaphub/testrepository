DROP TABLE IF EXISTS m_test;

CREATE TABLE m_test
(
   kamoku_cd VARCHAR(3) PRIMARY KEY,
   kamoku_name VARCHAR(20) NOT NULL,
   create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--トリガー用関数定義（レコード更新時に更新日時を設定）
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS '
BEGIN
  NEW.update_date := ''now'';
  RETURN NEW;
END;
' LANGUAGE 'plpgsql';

--トリガー作成（レコード更新時に更新日時を設定）
CREATE TRIGGER m_kamoku_update_timestamp
BEFORE UPDATE ON m_test
FOR EACH ROW
EXECUTE PROCEDURE update_updated_at_column();
