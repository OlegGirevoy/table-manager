package org.girevoy.tablemanager.service.impl;

import org.girevoy.tablemanager.dao.TableDao;
import org.girevoy.tablemanager.entity.Table;
import org.girevoy.tablemanager.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements TableService {
    private final TableDao tableDao;

    @Autowired
    public TableServiceImpl(TableDao tableDao) {
        this.tableDao = tableDao;
    }

    @Override
    public ResponseEntity<String> create(Table table) {
        try {
            tableDao.create(table);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (BadSqlGrammarException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @Override
    public ResponseEntity<String> delete(String tableName) {
        try {
            tableDao.delete(tableName);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (BadSqlGrammarException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }
}
