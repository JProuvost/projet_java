/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.EventListener;

/**
 *
 * @author Jean
 */
public interface TableButtonListener extends EventListener {
    public void tableButtonClicked(int row, int col);
}
