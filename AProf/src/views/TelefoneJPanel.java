package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;

public class TelefoneJPanel extends JPanel {

	private BindingGroup m_bindingGroup;
	private models.Telefone telefone;
	private JFormattedTextField numeroJFormattedTextField;
	private JComboBox tipoJComboBox;

	public TelefoneJPanel(models.Telefone newTelefone) {
		this();
		setTelefone(newTelefone);
	}

	public TelefoneJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0E-4 };
		setLayout(gridBagLayout);

		JLabel numeroLabel = new JLabel("Numero:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(numeroLabel, labelGbc_0);

		numeroJFormattedTextField = new JFormattedTextField();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 5);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(numeroJFormattedTextField, componentGbc_0);

		JLabel tipoLabel = new JLabel("Tipo:");
		GridBagConstraints labelGbc_1 = new GridBagConstraints();
		labelGbc_1.insets = new Insets(5, 5, 5, 5);
		labelGbc_1.gridx = 0;
		labelGbc_1.gridy = 1;
		add(tipoLabel, labelGbc_1);

		tipoJComboBox = new JComboBox();
		GridBagConstraints componentGbc_1 = new GridBagConstraints();
		componentGbc_1.insets = new Insets(5, 0, 5, 5);
		componentGbc_1.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_1.gridx = 1;
		componentGbc_1.gridy = 1;
		add(tipoJComboBox, componentGbc_1);

		if (telefone != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	protected BindingGroup initDataBindings() {
		BeanProperty<models.Telefone, java.lang.String> numeroProperty = BeanProperty.create("numero");
		BeanProperty<javax.swing.JFormattedTextField, java.lang.String> textProperty = BeanProperty.create("text");
		AutoBinding<models.Telefone, java.lang.String, javax.swing.JFormattedTextField, java.lang.String> autoBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, telefone, numeroProperty, numeroJFormattedTextField,
						textProperty);
		autoBinding.bind();
		//
		BeanProperty<models.Telefone, models.Tipo> tipoProperty = BeanProperty.create("tipo");
		BeanProperty<javax.swing.JComboBox, java.lang.Integer> selectedIndexProperty = BeanProperty
				.create("selectedIndex");
		AutoBinding<models.Telefone, models.Tipo, javax.swing.JComboBox, java.lang.Integer> autoBinding_1 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, telefone, tipoProperty, tipoJComboBox,
						selectedIndexProperty);
		autoBinding_1.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		//
		return bindingGroup;
	}

	public models.Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(models.Telefone newTelefone) {
		setTelefone(newTelefone, true);
	}

	public void setTelefone(models.Telefone newTelefone, boolean update) {
		telefone = newTelefone;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (telefone != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}

}
