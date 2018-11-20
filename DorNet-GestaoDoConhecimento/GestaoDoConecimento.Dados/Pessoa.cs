
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace GestaoDoConecimento.Dados
{
    [Table("pessoa")]
    public class Pessoa
    {
        [Key]
        [Column("id_pessoa")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [Column("nome")]
        [StringLength(200)]
        [Display(Name = "Nome")]
        public string NomePessoa { get; set; }

        [Column("matricula")]
        public int Matricula { get; set; }

        [Column("email")]
        [DataType(DataType.EmailAddress, ErrorMessage = "E-mail em formato inválido.")]
        [EmailAddress]
        public string Email { get; set; }

        [Column("atividade")]
        [Display(Name = "Qnt de Atividades")]
        public List<Atividade> Atividades { get; set; }
    }
}