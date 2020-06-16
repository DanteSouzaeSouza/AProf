package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;

public class TipoJPanel extends JPanel {

	private BindingGroup m_bindingGroup;
	private models.Tipo tipo;
	private JComboBox valorJComboBox;

	public TipoJPanel(models.Tipo newTipo) {
		this();
		setTipo(newTipo);
	}

	public TipoJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0E-4 };
		setLayout(gridBagLayout);

		JLabel valorLabel = new JLabel("Valor:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(valorLabel, labelGbc_0);

		valorJComboBox = new JComboBox();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 5);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(valorJComboBox, componentGbc_0);

		if (tipo != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	protected BindingGroup initDataBindings() {
		BeanProperty<models.Tipo, java.lang.Integer> valorProperty = BeanProperty.create("valor");
		BeanProperty<javax.swing.JComboBox, java.lang.Integer> valueProperty = BeanProperty.create("value");
		AutoBinding<models.Tipo, java.lang.Integer, javax.swing.JComboBox, java.lang.Integer> autoBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, tipo, valorProperty, valorJComboBox, valueProperty);
		autoBinding.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		bindingGroup.addBinding(autoBinding);
		//
		return bindingGroup;
	}

	public models.Tipo getTipo() {
		return tipo;
	}

	public void setTipo(models.Tipo newTipo) {
		setTipo(newTipo, true);
	}

	public void setTipo(models.Tipo newTipo, boolean update) {
		tipo = newTipo;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (tipo != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}

}
