package com.paulograbin.SimpleCRUD;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Main extends javax.swing.JFrame {

    private int id;

    private HibernateUtil hibernate;
    private Pessoas pessoa;
    private PessoasTableModel utm;

    private ButtonGroup grpSexo;
    private JButton btnInserir;
    private JButton btnAtualizar;
    private JButton btnDeletar;
    private JButton btnRefresh;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JRadioButton rdoM;
    private JRadioButton rdoF;
    private JScrollPane jScrollPane1;
    private JSpinner spnIdade;
    private JTable tblRegistros;
    private JTextField txtNome;
    private JLabel label;


    public Main() {
        try {
            hibernate = new HibernateUtil();
            pessoa = new Pessoas();
            initComponents();

            utm = new PessoasTableModel();
            tblRegistros.setModel(utm);

            setLocationRelativeTo(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error initializing application: " + e.getMessage(),
                    "Initialization Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private boolean validarCampos() {
        if (jLabel1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if ((Integer) spnIdade.getValue() < 0) {
            JOptionPane.showMessageDialog(null, "Informe uma idade valida", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!rdoM.isSelected() && !rdoF.isSelected()) {
            JOptionPane.showMessageDialog(null, "Informe o sexo", null, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void setPessoas() {
        pessoa = new Pessoas();

        pessoa.setNome(txtNome.getText());
        pessoa.setIdade((Integer) spnIdade.getValue());

        if (rdoM.isSelected())
            pessoa.setSexo('M');
        else if (rdoF.isSelected())
            pessoa.setSexo('F');

        pessoa.setId(id);

        label.setText(String.valueOf(pessoa.getId()));
    }

    private void atualizarTabela() {
        utm.atualizaDados();
        tblRegistros.repaint();
    }

    private void limparCampos() {
        id = 0;
        txtNome.setText("");
        spnIdade.setValue(0);
        grpSexo.clearSelection();
    }

    private void initComponents() {
        grpSexo = new ButtonGroup();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        txtNome = new JTextField();
        btnInserir = new JButton();
        btnAtualizar = new JButton();
        btnDeletar = new JButton();
        btnRefresh = new JButton();
        spnIdade = new JSpinner();
        jScrollPane1 = new JScrollPane();
        tblRegistros = new JTable();
        rdoM = new JRadioButton();
        rdoF = new JRadioButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");
        jLabel2.setText("Idade");
        jLabel3.setText("Sexo");

        btnInserir.setText("Inserir");
        btnAtualizar.setText("Atualizar");
        btnDeletar.setText("Deletar");
        btnRefresh.setText("Refresh");

        tblRegistros.setModel(new PessoasTableModel());

        jScrollPane1.setViewportView(tblRegistros);

        grpSexo.add(rdoM);
        rdoM.setText("Masculino");

        grpSexo.add(rdoF);
        rdoF.setText("Feminino");

        label = new JLabel("New label");

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(18)
                                                                .addComponent(rdoM)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(rdoF))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel2))
                                                                .addGap(18)
                                                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(spnIdade, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(label))
                                                                        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
                                                                .addComponent(btnAtualizar, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                                                .addComponent(btnInserir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnRefresh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        )
                                                        .addComponent(btnDeletar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                ))
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnInserir))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(spnIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label)
                                        .addComponent(btnAtualizar))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRefresh))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnDeletar)
                                        .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(rdoM))
                                        .addComponent(rdoF))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        btnInserir.addActionListener(e -> {
            if (validarCampos()) {
                id = 0;
                setPessoas();
                hibernate.insert(pessoa);
                utm.fireTableDataChanged();
                limparCampos();
                atualizarTabela();
            }
        });
        btnAtualizar.addActionListener(e -> {
            if (validarCampos()) {
                setPessoas();
                hibernate.updatePessoa(pessoa);
                atualizarTabela();

            }
        });
        btnDeletar.addActionListener(e -> {
            if (id > 0) {
                setPessoas();
                hibernate.deletePessoa(pessoa.getId());
                atualizarTabela();
            }
        });

        btnRefresh.addActionListener(e -> {
            atualizarTabela();
        });

        tblRegistros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int linha = tblRegistros.getSelectedRow();

                id = Integer.valueOf(tblRegistros.getModel().getValueAt(linha, 0) + "");
                System.out.println("ID: " + id);

                txtNome.setText(tblRegistros.getModel().getValueAt(linha, 1) + "");
                System.out.println("Nome: " + tblRegistros.getModel().getValueAt(linha, 1) + "");

                spnIdade.setValue(tblRegistros.getModel().getValueAt(linha, 2));
                System.out.println("Idade: " + tblRegistros.getModel().getValueAt(linha, 2));

                if ((Character) tblRegistros.getModel().getValueAt(linha, 3) == 'M')
                    rdoM.setSelected(true);
                else if ((Character) tblRegistros.getModel().getValueAt(linha, 3) == 'F')
                    rdoF.setSelected(true);

                System.out.println("");
                setPessoas();
            }
        });

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    class PessoasTableModel extends AbstractTableModel {
        List<Pessoas> tableData;
        String[] allColumns = {"id", "idade", "nome", "sexo"};
        HibernateUtil hu;

        public PessoasTableModel() {
            hu = new HibernateUtil();

            this.tableData = hu.selectAll();
        }

        public void atualizaDados() {
            this.tableData = hu.selectAll();
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            Pessoas user = tableData.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return user.getId();
                case 1:
                    return user.getNome();
                case 2:
                    return user.getIdade();
                case 3:
                    return user.getSexo();
                default:
                    return "";
            }
        }

        public int getRowCount() {
            return tableData.size();
        }

        public int getColumnCount() {
            return allColumns.length;
        }

        @Override
        public String getColumnName(int column) {
            return allColumns[column];
        }
    }
}
