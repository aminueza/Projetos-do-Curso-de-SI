using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using GestaoDoConecimento.Dados;
using GestaoDoConhecimento.Persistencia;

namespace GestaoDoConhecimento.Apresentacao.Controllers
{
    public class AtividadeController : Controller
    {
        private DBContexto db = new DBContexto();

        // GET: Atividade
        public ActionResult Index()
        {
            var atividades = db.Atividades.Include(a => a.Pessoa);
            return View(atividades.ToList());
        }

        // GET: Atividade/Details/5
        public ActionResult Details(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Atividade atividade = db.Atividades.Find(id);
            if (atividade == null)
            {
                return HttpNotFound();
            }
            return View(atividade);
        }

        // GET: Atividade/Create
        public ActionResult Create()
        {
            ViewBag.PessoaId = new SelectList(db.Pessoas, "Id", "NomePessoa");
            return View();
        }

        // POST: Atividade/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,NomeAtividade,PessoaId,Local,DataInicio,HoraInicio,DataFim,HoraFim,TipoDeAtividade,Descricao")] Atividade atividade)
        {
            if (ModelState.IsValid)
            {
                db.Atividades.Add(atividade);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.PessoaId = new SelectList(db.Pessoas, "Id", "NomePessoa", atividade.PessoaId);
            return View(atividade);
        }

        // GET: Atividade/Edit/5
        public ActionResult Edit(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Atividade atividade = db.Atividades.Find(id);
            if (atividade == null)
            {
                return HttpNotFound();
            }
            ViewBag.PessoaId = new SelectList(db.Pessoas, "Id", "NomePessoa", atividade.PessoaId);
            return View(atividade);
        }

        // POST: Atividade/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,NomeAtividade,PessoaId,Local,DataInicio,HoraInicio,DataFim,HoraFim,TipoDeAtividade,Descricao")] Atividade atividade)
        {
            if (ModelState.IsValid)
            {
                db.Entry(atividade).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.PessoaId = new SelectList(db.Pessoas, "Id", "NomePessoa", atividade.PessoaId);
            return View(atividade);
        }

        // GET: Atividade/Delete/5
        public ActionResult Delete(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Atividade atividade = db.Atividades.Find(id);
            if (atividade == null)
            {
                return HttpNotFound();
            }
            return View(atividade);
        }

        // POST: Atividade/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(long id)
        {
            Atividade atividade = db.Atividades.Find(id);
            db.Atividades.Remove(atividade);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        public ActionResult GetProblema(long? id)
        {
            if (!id.HasValue)
            {
                return HttpNotFound();
            }
            Atividade atividade = db.Atividades.Find(id);
            var problema = db.Problemas.Where(a => a.Atividade.NomeAtividade == atividade.NomeAtividade).ToList();
            return View(atividade);
        }

        public ActionResult GetSolucao(long? id)
        {
            if (!id.HasValue)
            {
                return HttpNotFound();
            }
            Atividade atividade = db.Atividades.Find(id);
            var solucao = db.Solucoes.Where(a => a.Atividade.NomeAtividade == atividade.NomeAtividade).ToList();
            return View(solucao);
        }
    }
}
