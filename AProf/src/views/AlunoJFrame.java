package views;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import models.Aluno;

import java.util.Date;
import javax.swing.JSeparator;

public class AlunoJFrame extends JFrame {

	private BindingGroup m_bindingGroup;
	private JPanel m_contentPane;
	private models.Aluno aluno;
	private JTextField nomeJTextField;
	private JTextField cpfJTextField;
	private JTextField dtnascJTextField;
	private JTextField rgJTextField;
	private JTextField raJTextField;
	private JSeparator separator;
	private TelefoneJPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoJFrame frame = new AlunoJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlunoJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 506);
		m_contentPane = new JPanel();
		setContentPane(m_contentPane);
		m_contentPane.setLayout(null);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(13, 8, 31, 14);
		m_contentPane.add(nomeLabel);

		nomeJTextField = new JTextField();
		nomeJTextField.setBounds(54, 8, 299, 20);
		m_contentPane.add(nomeJTextField);

		JLabel cpfLabel = new JLabel("Cpf:");
		cpfLabel.setBounds(13, 38, 21, 14);
		m_contentPane.add(cpfLabel);

		cpfJTextField = new JTextField();
		cpfJTextField.setBounds(54, 38, 299, 20);
		m_contentPane.add(cpfJTextField);

		JLabel dtnascLabel = new JLabel("Dtnasc:");
		dtnascLabel.setBounds(13, 68, 37, 14);
		m_contentPane.add(dtnascLabel);

		dtnascJTextField = new JTextField();
		dtnascJTextField.setBounds(54, 68, 299, 20);
		m_contentPane.add(dtnascJTextField);

		JLabel rgLabel = new JLabel("Rg:");
		rgLabel.setBounds(13, 98, 17, 14);
		m_contentPane.add(rgLabel);

		rgJTextField = new JTextField();
		rgJTextField.setBounds(54, 98, 299, 20);
		m_contentPane.add(rgJTextField);

		JLabel raLabel = new JLabel("Ra:");
		raLabel.setBounds(13, 128, 17, 14);
		m_contentPane.add(raLabel);

		raJTextField = new JTextField();
		raJTextField.setBounds(54, 128, 299, 20);;
		m_contentPane.add(raJTextField);
		
		separator = new JSeparator();
		separator.setBounds(0, 0, 0, 0);
		m_contentPane.add(separator);
		
		panel = new TelefoneJPanel();
		panel.setBounds(29, 196, 206, 124);
		m_contentPane.add(panel);

		if (aluno != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	public models.Aluno getAluno() {
		return aluno;
	}

	public void setAluno(models.Aluno newAluno) {
		setAluno(newAluno, true);
	}

	public void setAluno(models.Aluno newAluno, boolean update) {
		aluno = newAluno;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (aluno != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}
	protected BindingGroup initDataBindings() {
		BeanProperty<Aluno, String> nomeProperty = BeanProperty.create("nome");
		BeanProperty<JTextField, String> textProperty = BeanProperty.create("text");
		AutoBinding<Aluno, String, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, aluno, nomeProperty, nomeJTextField, textProperty);
		autoBinding.bind();
		//
		BeanProperty<Aluno, String> cpfProperty = BeanProperty.create("cpf");
		BeanProperty<JTextField, String> textProperty_1 = BeanProperty.create("text");
		AutoBinding<Aluno, String, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ, aluno, cpfProperty, cpfJTextField, textProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<Aluno, Date> dtnascProperty = BeanProperty.create("dtnasc");
		BeanProperty<JTextField, String> textProperty_2 = BeanProperty.create("text");
		AutoBinding<Aluno, Date, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ, aluno, dtnascProperty, dtnascJTextField, textProperty_2);
		autoBinding_2.bind();
		//
		BeanProperty<Aluno, String> rgProperty = BeanProperty.create("rg");
		BeanProperty<JTextField, String> textProperty_3 = BeanProperty.create("text");
		AutoBinding<Aluno, String, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ, aluno, rgProperty, rgJTextField, textProperty_3);
		autoBinding_3.bind();
		//
		BeanProperty<Aluno, Integer> alunoBeanProperty = BeanProperty.create("ra");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Aluno, Integer, JTextField, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ, aluno, alunoBeanProperty, raJTextField, jTextFieldBeanProperty);
		autoBinding_4.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		//
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		bindingGroup.addBinding(autoBinding_2);
		bindingGroup.addBinding(autoBinding_3);
		bindingGroup.addBinding(autoBinding_4);
		return bindingGroup;
	}
}
