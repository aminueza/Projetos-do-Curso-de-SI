using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace AluguelCarros.Models
{
    [Table("telefone")]
    public class Telefone
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        [Column("id_telefone")]
        [ScaffoldColumn(false)]
        public int Id { get; set; }

        [StringLength(15)]
        [Column("tipo")]
        public string Tipo { get; set; }

        [Column("numero")]
        public int Numero { get; set; }

    }
}