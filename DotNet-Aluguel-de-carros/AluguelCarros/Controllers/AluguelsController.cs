using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using AluguelCarros.Models;

namespace AluguelCarros.Controllers
{
    public class AluguelsController : Controller
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: Aluguels
        public ActionResult Index()
        {
            return View(db.Aluguels.ToList());
        }

        // GET: Aluguels/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Aluguel aluguel = db.Aluguels.Find(id);
            if (aluguel == null)
            {
                return HttpNotFound();
            }
            return View(aluguel);
        }

        // GET: Aluguels/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Aluguels/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,DataAluguel,DataDevolucao")] Aluguel aluguel)
        {
            if (ModelState.IsValid)
            {
                db.Aluguels.Add(aluguel);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(aluguel);
        }

        // GET: Aluguels/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Aluguel aluguel = db.Aluguels.Find(id);
            if (aluguel == null)
            {
                return HttpNotFound();
            }
            return View(aluguel);
        }

        // POST: Aluguels/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,DataAluguel,DataDevolucao")] Aluguel aluguel)
        {
            if (ModelState.IsValid)
            {
                db.Entry(aluguel).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(aluguel);
        }

        // GET: Aluguels/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Aluguel aluguel = db.Aluguels.Find(id);
            if (aluguel == null)
            {
                return HttpNotFound();
            }
            return View(aluguel);
        }

        // POST: Aluguels/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Aluguel aluguel = db.Aluguels.Find(id);
            db.Aluguels.Remove(aluguel);
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
