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
    public class SolucaoController : Controller
    {
        private DBContexto db = new DBContexto();

        // GET: Solucao
        public ActionResult Index()
        {
            var solucoes = db.Solucoes.Include(s => s.Atividade);
            return View(solucoes.ToList());
        }

        // GET: Solucao/Details/5
        public ActionResult Details(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Solucao solucao = db.Solucoes.Find(id);
            if (solucao == null)
            {
                return HttpNotFound();
            }
            return View(solucao);
        }

        // GET: Solucao/Create
        public ActionResult Create()
        {
            ViewBag.AtividadeId = new SelectList(db.Atividades, "Id", "NomeAtividade");
            return View();
        }

        // POST: Solucao/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,AtividadeId,NomeSolucao,Descricao")] Solucao solucao)
        {
            if (ModelState.IsValid)
            {
                db.Solucoes.Add(solucao);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.AtividadeId = new SelectList(db.Atividades, "Id", "NomeAtividade", solucao.AtividadeId);
            return View(solucao);
        }

        // GET: Solucao/Edit/5
        public ActionResult Edit(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Solucao solucao = db.Solucoes.Find(id);
            if (solucao == null)
            {
                return HttpNotFound();
            }
            ViewBag.AtividadeId = new SelectList(db.Atividades, "Id", "NomeAtividade", solucao.AtividadeId);
            return View(solucao);
        }

        // POST: Solucao/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,AtividadeId,NomeSolucao,Descricao")] Solucao solucao)
        {
            if (ModelState.IsValid)
            {
                db.Entry(solucao).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.AtividadeId = new SelectList(db.Atividades, "Id", "NomeAtividade", solucao.AtividadeId);
            return View(solucao);
        }

        // GET: Solucao/Delete/5
        public ActionResult Delete(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Solucao solucao = db.Solucoes.Find(id);
            if (solucao == null)
            {
                return HttpNotFound();
            }
            return View(solucao);
        }

        // POST: Solucao/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(long id)
        {
            Solucao solucao = db.Solucoes.Find(id);
            db.Solucoes.Remove(solucao);
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
    }
}
