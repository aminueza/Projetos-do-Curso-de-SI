using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Consultorio
{
    [Table("paciente")]
    public class Paciente
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }

        [Column("nome_paciente")]
        [StringLength(50)]
        [Required(ErrorMessage = "O nome do paciente é obrigatório")]
        public string Nome { get; set; }

        [Column("cartao_sus")]
        [Required(ErrorMessage = "O numero do cartao sus é obrigatório")]
        public int CartaoSus { get; set; }
    }
}
