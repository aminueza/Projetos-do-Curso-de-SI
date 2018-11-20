using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Consultorio
{
    [Table("medico")]
    public class Medico
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }

        [Column("nome_medico")]
        [StringLength(50)]
        [Required(ErrorMessage = "O nome do medico é obrigatório")]
        public string Nome { get; set; }

        [Column("crm")]
        [Required(ErrorMessage = "O numero do Crm é obrigatório")]
        public int Crm { get; set; }

        public Especialidade especialidade { get; set; }
    }
}
