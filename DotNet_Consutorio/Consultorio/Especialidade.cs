using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Consultorio
{
    [Table("especialidade")]
    public class Especialidade
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }

        [Column("nome_especialidade")]
        [StringLength(50)]
        [Required(ErrorMessage = "O nome da especialidade é obrigatório")]
        public string NomeDaEspecialidade { get; set; }

        public List<Medico> Medicos { get; set; }

        public Especialidade()
        {
            Medicos = new List<Medico>();
        }
    }
}