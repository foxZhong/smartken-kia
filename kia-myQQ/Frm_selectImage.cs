using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace myQQ
{
    public partial class Frm_selectImage : Form
    {
        Frm_rege parent;
        Frm_info parent2;
        ImageList ilFace;
        public Frm_selectImage(Frm_rege f)
        {
            InitializeComponent();
            this.parent = f;
            this.ilFace = f.getImageList();
            lvFace.LargeImageList = ilFace;
            lvFace2.LargeImageList = ilFace;
        }

        public Frm_selectImage(Frm_info f)
        {
            InitializeComponent();
            this.parent2 = f;
            this.ilFace = f.ilFace;
            lvFace.LargeImageList = ilFace;
            lvFace2.LargeImageList = ilFace;
        }

        private void Frm_selectImage_Load(object sender, EventArgs e)
        {
            
            int count = 33;
            for (int i = 0; i <14; i++)
                lvFace.Items.Add(null, i.ToString(), i);
            for (int i = 14; i < count; i++)
               lvFace2.Items.Add(null, i.ToString(), i);
        }

        private void btnConfirm_Click(object sender, EventArgs e)
        {
            if (parent != null)
            {
                if (lvFace.SelectedItems.Count > 0)
                { parent.imageID = lvFace.SelectedItems[0].ImageIndex; }
                else if ((lvFace2.SelectedItems.Count > 0))
                { parent.imageID = lvFace2.SelectedItems[0].ImageIndex; }
                parent.setImage();
                this.Dispose();
            }
            else if (parent2 != null)
            {
                if (lvFace.SelectedItems.Count > 0)
                { parent2.faceID = lvFace.SelectedItems[0].ImageIndex; }
                else if ((lvFace2.SelectedItems.Count > 0))
                { parent2.faceID = lvFace2.SelectedItems[0].ImageIndex; }
                parent2.setFace();
                this.Dispose();
            }
        }

        private void btnCancle_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void lvFace_SelectedIndexChanged(object sender, EventArgs e)
        {
            lvFace2.SelectedItems.Clear();
           

        }

        private void lvFace2_SelectedIndexChanged(object sender, EventArgs e)
        {
            lvFace.SelectedItems.Clear();
           
        }

        private void tsmiLargeView_Click(object sender, EventArgs e)
        {
            lvFace.View = View.LargeIcon;
            lvFace2.View = View.LargeIcon;
        }

        private void tsmiSmallView_Click(object sender, EventArgs e)
        {
            lvFace.View = View.SmallIcon;
            lvFace2.View = View.SmallIcon;
        }

    }
}