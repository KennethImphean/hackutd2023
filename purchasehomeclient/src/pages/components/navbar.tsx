import { useRouter } from "next/router";
import Link from "next/link";
import React from 'react';

const Navbar = () => {
  return (

    <nav className="fixed w-full h-20 shadow-xl bg-midnight">
      <div className="flex justify-between items-center h-full w-full px-4 text-white">
        <div className="text-white hover:text-slate-400 transition">
          <Link href ="/">
            Home Pre-Approval
          </Link>
        </div>
        <div>
          <ul className="hidden sm:flex">
            <Link href="/exampledata">
            <li className="ml-10 uppercase hover:border-b text-lg hover:text-slate-400 transition ">Example Data</li>
            </Link>
            <Link href="/userinputdata">
            <li className="ml-10 uppercase hover:border-b text-lg hover:text-slate-400 transition ">User-Input Data</li>
            </Link>
          </ul>
        </div>
      </div>

    </nav>
  )
}

export default Navbar;