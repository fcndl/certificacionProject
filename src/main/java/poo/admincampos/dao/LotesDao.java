/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.admincampos.dao;

import java.util.List;
import poo.admincampos.Lote;

/**
 *
 * @author facundo
 */
public interface LotesDao {
    public Lote buscarPorNumeroLote (Integer numeroLote);
    public boolean registrarLotes(List<Lote>lotes);
}
