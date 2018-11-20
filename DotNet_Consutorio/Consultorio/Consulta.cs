using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Consultorio
{
    [Table("consulta")]
    public class Consulta
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }
        [Column("descricao")]
        [StringLength(50)]
        [Required(ErrorMessage = "A descricao é obrigatório")]
        public string Descricao { get; set; }
        [Column("data")]
        [Required(ErrorMessage = "A data é obrigatório")]
        public DateTime Data { get; set; }
        [Column("hora")]
        [Required(ErrorMessage = "A hora é obrigatório")]
        public DateTime Hora { get; set; }

        public Paciente Paciente { get; set; }

        public Medico Medico { get; set; }
    }
}
