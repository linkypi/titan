package com.c2.pandora.serverpanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import com.c2.pandora.MainPanel;
import com.c2.pandora.openstackserver.OpenstackServerFrame;

public class MainServerPanel extends JPanel implements MainPanel {
	JFrame parentFrame;

	public MainServerPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		setBorder(new EmptyBorder(10, 10, 0, 10));
		setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("Servers");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(label, BorderLayout.NORTH);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);

		ServerPanel serverPanel = new ServerPanel();
		ServerPanel.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					System.out.println("ok");
					OpenstackServerFrame f = new OpenstackServerFrame(MainServerPanel.this.parentFrame);
					f.setVisible(true);
				}
			}
		});
		tabbedPane.addTab("Server", null, serverPanel, null);

		ServerGraphPanel serverGraphPanel = new ServerGraphPanel();
		tabbedPane.addTab("Graph", null, serverGraphPanel, null);

	}

	public void refresh() {

	}

}